package org.myworkspace.MovieMania.Resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myworkspace.MovieMania.Entities.enums.Genre;

import java.util.List;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class MovieResource {
    private long id;
    private String title;
    private Genre genre;
    private List<ReviewResource> reviews;

}
