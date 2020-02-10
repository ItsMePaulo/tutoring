cmake_minimum_required(VERSION 3.15)
project(practical_notes)

set(CMAKE_CXX_STANDARD 14)

add_executable(practical_notes Person/main.cpp Person/Person.cpp Person/Person.h)