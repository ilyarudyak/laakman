cmake_minimum_required(VERSION 3.3)
project(recursion)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp Parens.h MagicIndex.h Staircase.h RobotMove.h Coins.h)
add_executable(recursion ${SOURCE_FILES})