package com.ssebide.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssebide.modal.PlanType;
import com.ssebide.modal.Subscription;
import com.ssebide.modal.User;
import com.ssebide.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private UserService userService;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription createSubscription(User user) {
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setPlanType(PlanType.FREE);
        subscription.setSubscriptionStarDate(LocalDate.now());
        subscription.setSubscriptionEndDate(LocalDate.now().plusMonths(12));
        subscription.setValid(true);

        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription getUserSubscription(Long userId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserSubscription'");
    }

    @Override
    public Subscription upgradeSubscription(Long userId, PlanType planType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upgradeSubscription'");
    }

    @Override
    public boolean isValid(Subscription subscription) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

}
