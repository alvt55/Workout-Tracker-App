package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GymSessionTest {

    GymExercise exercise1;
    GymExercise bwExercise;
    GymExercise exercise2;
    GymExercise exercise3;

    ArrayList<GymExercise> exerciseList;

    GymSession session;

    EventLog el;


    @BeforeEach
    public void setup() {
        exercise1 = new GymExercise("Dumbell Curls", 20, 0, 4, 12);
        bwExercise = new GymExercise("Push ups", 0, 80, 4, 30);
        exercise2 = new GymExercise("Lat Pullover", 50, 0, 3, 13);
        exercise3 = new GymExercise("Leg press", 200, 0, 3, 10);

        exerciseList = new ArrayList<GymExercise>();
        exerciseList.add(exercise1);
        exerciseList.add(bwExercise);

        session = new GymSession(exerciseList, "Feb 3, 2024");
        el = EventLog.getInstance();
    }

    @Test
    public void testTotalWeightLifted() {
        assertEquals(((20*4*12) + (80*4*30)), session.totalWeightLifted());
    }


    // w Event("Added " + exercise.getName() + " to " + date)

    @Test
    // 1. adding one exercise
    public void testAddOneExercise() {
        session.addExercise(exercise2);
//        Event e = new Event("Added " + exercise2.getName() + " to " + session.getDate());
//
//        ArrayList<Event> l = new ArrayList<Event>();
//
//        for (Event next : el) {
//            l.add(next);
//        }
//
//        assertTrue(l.contains(e));

        ArrayList<GymExercise> temp = new ArrayList<GymExercise>();
        temp.add(exercise1);
        temp.add(bwExercise);
        temp.add(exercise2);
        assertEquals(temp, session.getListOfGymExercise());
    }

    @Test
    // 2. adding multiple exercises
    public void testAddMultipleExercise() {
        session.addExercise(exercise2);
        ArrayList<GymExercise> temp = new ArrayList<GymExercise>();
        temp.add(exercise1);
        temp.add(bwExercise);
        temp.add(exercise2);
        assertEquals(temp, session.getListOfGymExercise());

        session.addExercise(exercise3);
        temp.add(exercise3);
        assertEquals(temp, session.getListOfGymExercise());
    }

    @Test
    public void testtoString() {
        String answer = session.getDate() + "\n" + exercise1.toString() + "\n" + bwExercise.toString() + "\n";
        assertEquals(answer, session.toString());
    }






}
