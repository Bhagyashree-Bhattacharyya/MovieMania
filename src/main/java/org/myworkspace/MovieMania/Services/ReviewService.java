package org.myworkspace.MovieMania.Services;

import org.myworkspace.MovieMania.Repositories.MovieRepository;
import org.myworkspace.MovieMania.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.myworkspace.MovieMania.Entities.Review;
import org.myworkspace.MovieMania.Entities.Movie;
import org.myworkspace.MovieMania.Resources.ReviewResource;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addReview(Review review) {
        Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);
        reviewRepository.save(review);
        // need to optimized -- reduce time complexity
        if(movie!=null) {
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }
    }

    public ReviewResource getReviewById(Long reviewId) {
        Optional<Review> review= reviewRepository.findById(reviewId);
        return review.map(Review::toResource).orElse(null);
    }
}
