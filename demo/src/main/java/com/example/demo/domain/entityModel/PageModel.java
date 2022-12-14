package com.example.demo.domain.entityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageModel<T> {
    private List<T> Items;
    private Integer TotalPagesCount;
}
