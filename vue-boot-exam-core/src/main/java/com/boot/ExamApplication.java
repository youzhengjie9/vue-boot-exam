package com.boot;

import com.boot.utils.SystemInfoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.UnknownHostException;
import java.util.TimeZone;

/**
 * 游政杰
 */
@SpringBootApplication
@EnableSwagger2
@Slf4j
public class ExamApplication {

  public static void main(String[] args) {

      ConfigurableApplicationContext applicationContext =
              SpringApplication.run(ExamApplication.class, args);

      log.info(SystemInfoUtils.getCpuInfo().toString());
      log.info(SystemInfoUtils.getJvmInfo().toString());
      log.info(SystemInfoUtils.getMemInfo().toString());
      log.info(SystemInfoUtils.getSysFileInfo().toString());
      try {
         log.info(SystemInfoUtils.getSysInfo().toString());
      } catch (UnknownHostException e) {
          e.printStackTrace();
      }
      try {
          log.info(SystemInfoUtils.getInfo().toString());
      } catch (UnknownHostException e) {
          e.printStackTrace();
      }
  }
}
