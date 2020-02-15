cmake_minimum_required(VERSION 3.15)
project(person)

set(SOURCE_FILES main.cpp NewPerson.cpp NewPerson.h)

add_executable(person ${SOURCE_FILES})