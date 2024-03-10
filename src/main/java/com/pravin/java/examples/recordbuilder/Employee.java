package com.pravin.java.examples.recordbuilder;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record Employee(Long id, String name, String company, Integer age) {}