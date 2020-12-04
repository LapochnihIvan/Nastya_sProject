package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Questions {
    public Questions() {
        quests = new String[20];
        correctAns = new short[20];
        textsAns = new String[20][4];
        numRound = 0;
    }

    public void nextRound() {
        numRound++;
    }

    public boolean isEmpty() {
        return numRound == 20;
    }

    public String getQuest() {
        return quests[numRound];
    }

    public short getCorrectAns() {
        return correctAns[numRound];
    }

    public String[] getTextsAns() {
        return textsAns[numRound];
    }

    public final ArrayList<String> getErrorFiles() throws IOException {
        ArrayList<String> errorFiles;
        Reader stream = new Reader();
        if ((errorFiles = stream.catchErrors()).isEmpty()) {
            if ((errorFiles = stream.catchFatalErrors()).isEmpty()) {
                stream.read(quests, textsAns, correctAns);
            }
        }
        return errorFiles;
    }

    private final String[] quests;
    private final short[] correctAns;
    private final String[][] textsAns;
    private short numRound;
}