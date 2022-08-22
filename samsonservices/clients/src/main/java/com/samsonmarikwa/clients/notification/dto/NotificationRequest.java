package com.samsonmarikwa.clients.notification.dto;

public record NotificationRequest(Integer toCustomerId, String toCustomerEmail, String message) {
}
