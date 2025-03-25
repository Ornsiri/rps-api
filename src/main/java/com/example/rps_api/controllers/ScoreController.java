package com.example.rps_api.controllers;

import com.example.rps_api.models.Score;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ScoreController {
    static Score score = new Score(0,0,0);

    @GetMapping("/score")
    public Score getScore() {
        return score;
    }

    @PutMapping("/score")
    public Score setScore(@RequestBody Score score){
        ScoreController.score = score;
        return ScoreController.score;
    }

    @DeleteMapping("/score")
    public void deleteScore() {
        ScoreController.score = null;
    }

    @PatchMapping("/score/wins")
    public Score setWins(@RequestParam(name = "value")int value) {
        score.setWins(value);
        return score;
    }

    @PatchMapping("/score/losses")
    public Score setLosses(@RequestParam(name = "value")int value) {
        score.setLosses(value);
        return score;
    }

    @PatchMapping("/score/ties")
    public Score setTies(@RequestParam(name = "value")int value) {
        score.setTies(value);
        return score;
    }

    @GetMapping("/score/{result}")
    public int getResult(@PathVariable String result){
        if (result.equalsIgnoreCase("wins")) {
            return score.getWins();
        }
        if (result.equalsIgnoreCase("losses")) {
            return score.getLosses();
        }
        return score.getTies();
    }

    @PostMapping("/score/wins")
    public Score increaseWins() {
        int win = score.getWins();
        win++;
        score.setWins(win);
        return score;
    }

    @PostMapping("/score/losses")
    public Score increaseLosses() {
        int loss = score.getLosses();
        loss++;
        score.setLosses(loss);
        return score;
    }

    @PostMapping("/score/ties")
    public Score increaseTies() {
        int ties = score.getTies();
        ties++;
        score.setTies(ties);
        return score;
    }


}
