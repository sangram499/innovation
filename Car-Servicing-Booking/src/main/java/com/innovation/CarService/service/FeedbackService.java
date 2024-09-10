// FeedbackService.java
package com.innovation.CarService.service;

import java.util.List;

import com.innovation.CarService.model.Feedback;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    Feedback getFeedbackById(Long id);
    
    List<Feedback> getAllFeedback();

}
