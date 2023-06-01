package io.codekaffee.pocs.jdbipoc.domain.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @ColumnName("id")
    private Long id;

    @ColumnName("title")
    private String title;

    @ColumnName("launch_year")
    private Integer launchYear;

    @ColumnName("genre")
    private String genre;

}
