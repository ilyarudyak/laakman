cmake_minimum_required(VERSION 3.5)
project(ch3_linked_list)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp LinkedList.h)
add_executable(ch3_linked_list ${SOURCE_FILES})