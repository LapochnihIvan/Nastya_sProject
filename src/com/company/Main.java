package com.company;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        final Main main = new Main();
        main.process();
    }

    private final GUI gui;
    private final Questions questions;

    private Main() {
        gui = new GUI();
        questions = new Questions();
    }

    private void process() throws IOException {
        if (!gui.createErrorWindow(questions.getErrorFiles())) {
            gui.generation();
            gui.setQuestFrame(questions.getQuest(), questions.getTextsAns());
            while (!questions.isEmpty()) {
               if (gui.getResponse() == questions.getCorrectAns()) {
                   questions.nextRound();
                   if (questions.isEmpty()) gui.endOfQuiz();
                   else gui.setQuestFrame(questions.getQuest(), questions.getTextsAns());
               }
               else gui.wrongAns();
            }
        }
    }
}