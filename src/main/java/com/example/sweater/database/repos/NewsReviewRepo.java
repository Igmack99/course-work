package com.example.sweater.database.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sweater.database.entities.NewsReview;

public interface NewsReviewRepo extends JpaRepository<NewsReview, Long> {


}
