package org.solvd.domain.services;

import org.solvd.domain.accident.Accident;
import org.solvd.domain.accident.AccidentListener;

import java.util.ArrayList;
import java.util.List;

public class Listeners {

    public static final List<AccidentListener> LISTENERS = new ArrayList();

    public static void onNewAccident(Accident accident) {
        for (AccidentListener accidentListener : LISTENERS) {
            accidentListener.onNewAccident(accident);
        }
    }

    public static void addListener(AccidentListener accidentListener) {
        LISTENERS.add(accidentListener);
    }

    public static void rmListener(AccidentListener accidentListener) {
        LISTENERS.remove(accidentListener);
    }
}
