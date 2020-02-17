cmake_minimum_required(VERSION 3.15)
project(tick_tack_toe)

set(SOURCE_FILES main.cpp ValidationClass.cpp ValidationClass.h GridClass.cpp GridClass.h GridElements.h)

add_executable(tick_tack_toe ${SOURCE_FILES})