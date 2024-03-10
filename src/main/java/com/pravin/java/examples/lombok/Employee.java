package com.pravin.java.examples.lombok;

import lombok.Builder;

@Builder
public record Employee(Long id, String name, String company, Integer age) {}
