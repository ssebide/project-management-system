package com.ssebide.service;

import com.ssebide.modal.PlanType;
import com.ssebide.modal.Subscription;
import com.ssebide.modal.User;

public interface SubscriptionService {

    Subscription createSubscription (User user);

    Subscription getUserSubscription(Long userId) throws Exception;

    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}
