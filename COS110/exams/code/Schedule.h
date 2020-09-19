//
// Created by momo on 9/17/20.
//

#ifndef CODE_SCHEDULE_H
#define CODE_SCHEDULE_H

#include "Activity.h"

class Schedule {
private:
    Activity ***mySchedule;
    int days; // number of cols
    int timeslots; // number of rows


public:
    Schedule(int d = 7, int t = 10) {
        days = 7;
        timeslots = 10;
    }

    // Question17  destruct the schedule class
    ~Schedule() {
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < timeslots; j++) {
                delete mySchedule[i][j];
            }
            delete mySchedule[i];
        }
    }

    void setSchedule(Activity ***act) {
        mySchedule = act;
    }

//    if(1 > 2) {
//        true block
//    } else
//    {
//        false block
//    }
//
//    (1 > 2) ? true  : else
//

    // Question 12: a big operation overloading task
    Schedule operator+(const Schedule &s) {
        Schedule newS = Schedule(this->days, this->timeslots);

        auto **tempArray = new Activity *[this->days];

        // whenever I say "this" I mean cos110
        for (int i = 0; i < this->days; ++i) {
            tempArray[i] = new Activity[this->timeslots];

            for (int j = 0; j < this->timeslots; j++) {

                if (this->mySchedule[i][j] != nullptr) {
                    // this condition looks for an overlap when both current obj and obj passed in have a course
                    // at the same time slot
                    // s is cos122
                    if (s.mySchedule[i][j]) {
                        // this line then assigned the activity based on the higher priority, use the ?: operator to make
                        // a quick inline if statement
                        tempArray[i][j] = this->mySchedule[i][j]->getPriority() > s.mySchedule[i][j]->getPriority()
                                          ? *this->mySchedule[i][j] : *s.mySchedule[i][j];
                    } else {
                        // if there is no overlap just assign the activity of the current obj
                        tempArray[i][j] = *this->mySchedule[i][j];
                    }
                } else if (s.mySchedule[i][j]) {
                    // we know that we can add safely without collision
                    tempArray[i][j] = *s.mySchedule[i][j];
                }
            }
        }
        newS.setSchedule(&tempArray);
        return newS;
    }
};


#endif //CODE_SCHEDULE_H
