cmake_minimum_required(VERSION 3.5)

project(Cpp LANGUAGES CXX)

set(CMAKE_CXX_FLAGS -std=c++2a)

add_executable(Cpp main.cpp
sumoddunderlimit.cpp
sumoddunderlimit.h)

include_directories(Cpp .)