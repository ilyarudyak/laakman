cmake_minimum_required(VERSION 3.3)
project(2_min_stack)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp MinStack.h MinStack2.h MinStack3.h)
add_executable(2_min_stack ${SOURCE_FILES})