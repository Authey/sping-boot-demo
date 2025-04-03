package spring.boot.demo.utils;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MybatisPlusGenerator {

    private static final String url = "jdbc:mysql://localhost:3306/spring_vue";

    private static final String username = "demo";

    private static final String password = "demo";

    private static final String author = "Authey";

    private static final String baseAddress = System.getProperty("user.dir") + "/backend/src/main";

    private static final String parent = "spring.boot.demo";

    private static final String tableName = "user";

    public static void main(String[] args) {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(author)
                            .dateType(DateType.ONLY_DATE)
                            .disableOpenDir()
                            .enableSpringdoc()
                            .outputDir(baseAddress + "/java");
                })
                .packageConfig(builder -> {
                    builder.parent(parent)
                            .controller("controller")
                            .entity("entity")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("service.impl")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, baseAddress + "/resources/mappers"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableName)
                            .controllerBuilder().enableRestStyle()
                            .entityBuilder().enableFileOverride()
                                    .naming(NamingStrategy.underline_to_camel)
                                    .columnNaming(NamingStrategy.underline_to_camel)
                                    .enableLombok()
                                    .enableTableFieldAnnotation()
                            .mapperBuilder().enableFileOverride()
                            .serviceBuilder().enableFileOverride()
                                    .formatServiceFileName("%sService");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
