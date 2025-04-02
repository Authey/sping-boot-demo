package study.room.demo.common;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Getter
public class PageData<T> {

    @Schema(description = "当前页码")
    private final long page;

    @Schema(description = "页面数据量")
    private final long size;

    @Schema(description = "数据总数")
    private final long total;

    @Schema(description = "当前页数据")
    private final List<T> records;

    public PageData(long page, long size, long total, List<T> records) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.records = records;
    }

}
