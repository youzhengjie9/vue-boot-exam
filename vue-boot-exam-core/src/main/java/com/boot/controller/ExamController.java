package com.boot.controller;

import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.nio.charset.Charset;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@CrossOrigin // ����ע��
@Controller
@Api("���Խӿ�")
@RequestMapping(path = "/exam")
public class ExamController {

  private final int FILE_SIZE = 1024 * 200; // 200KB

  @Autowired private RedisTemplate redisTemplate;

  private final String key = "questions"; // key

  @GetMapping(path = "/getQuestion")
  @ResponseBody
  public String getQuestion() {

    String question = (String) redisTemplate.opsForSet().randomMember(key);
    System.out.println(question);
    if (StringUtils.isBlank(question)) {
      throw new RuntimeException("û����Ŀ");
    }
    return question;
  }

  @GetMapping(path = "/init")
  @ResponseBody
  public String initQuestionDatabase() throws IOException {

    long start = System.currentTimeMillis();
    // ʹ���̳߳��첽�������

    ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(
            12,
            20,
            2L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    threadPoolExecutor.execute(() -> {

        // ��ȡ���
        try{

            File file = ResourceUtils.getFile("classpath:question-database.txt");

            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(file, Charset.forName("utf8")));

            String question = null;

            while ((question = bufferedReader.readLine()) != null) {

                redisTemplate.opsForSet().add(key,question);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

    long end = System.currentTimeMillis();
    return "��ʼ�����ɹ�������ʱ��" + (end - start) + "ms";
  }
}
