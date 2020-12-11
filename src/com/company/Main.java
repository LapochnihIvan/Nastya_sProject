package com.company;

import java.io.IOException;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        final Main main = new Main();
        main.process();
    }

    private final GUI gui;
    private final Questions questions;
    private final ArrayList<String> errorFiles;

    private Main() throws IOException {
        gui = new GUI();
        questions = new Questions();
        errorFiles = questions.getErrorFiles();
    }

    private void process() throws IOException {
        if (errorFiles.isEmpty()) {
            gui.generation();
            gui.setQuestFrame(questions.getQuest(), questions.getTextsAns());
            while (!questions.isEmpty()) {
                gui.setQuestFrame(questions.getQuest(), questions.getTextsAns());
                if (gui.getResponse() == questions.getCorrectAns()) {
                    questions.nextRound();
                }
                else gui.wrongAns();
            }
            gui.endOfQuiz();
        }
        else gui.createErrorWindow(errorFiles, questions.isFatalError());
    }
}