cmake_minimum_required(VERSION 3.3)
project(1_3stacks)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp MultiStack.h)
add_executable(1_3stacks ${SOURCE_FILES})