package com.jpreet.cdlwiki.controller;

import com.jpreet.cdlwiki.dto.MatchDTO;
import com.jpreet.cdlwiki.dto.MatchRequest;
import com.jpreet.cdlwiki.enums.RoundName;
import com.jpreet.cdlwiki.exception.CDLWikiException;
import com.jpreet.cdlwiki.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/match")
@Validated
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/")
    public ResponseEntity<List<MatchDTO>> getAllMatches() throws CDLWikiException {
        List<MatchDTO> matches = matchService.getAllMatches();
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping(value = "/", params = "date")
    public ResponseEntity<List<MatchDTO>> getAllMatchesBeforeAfterDate(@RequestParam("date") Date date) throws CDLWikiException {
        List<MatchDTO> matches;

        if (date.before(new Date())) {
            matches = matchService.getAllMatchesBeforeDate(date);
        } else {
            matches = matchService.getAllMatchesAfterDate(date);
        }

        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable Integer matchId) throws CDLWikiException {
        MatchDTO match = matchService.getMatchById(matchId);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @GetMapping(value = "/team/{teamId}", params = "date")
    public ResponseEntity<List<MatchDTO>> getMatchesByTeamBeforeAfterDate(@PathVariable Integer teamId, @RequestParam("date") Date date) throws CDLWikiException {
        List<MatchDTO> matches;

        if (date.before(new Date())) {
            matches = matchService.getMatchesByTeamBeforeDate(teamId, date);
        } else {
            matches = matchService.getMatchesByTeamAfterDate(teamId, date);
        }

        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping(value = "/team/{teamId}/latest", params = "date")
    public ResponseEntity<List<MatchDTO>> getPreviousNext5ByTeam(@PathVariable Integer teamId, @RequestParam("date") Date date) throws CDLWikiException {
        List<MatchDTO> matches;

        if (date.before(new Date())) {
            matches = matchService.getPrevious5ByTeam(teamId, date);
        } else {
            matches = matchService.getNext5ByTeam(teamId, date);
        }

        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping("/team")
    public ResponseEntity<List<MatchDTO>> getMatchesByTeamsPlaying(@RequestParam Integer team1Id, @RequestParam Integer team2Id) throws CDLWikiException {
        List<MatchDTO> matches = matchService.getMatchesByTeamsPlaying(team1Id, team2Id);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping(value = "/major/{majorId}", params = "date")
    public ResponseEntity<List<MatchDTO>> getMatchesByMajorBeforeAfterDate(@PathVariable Integer majorId, @RequestParam("date") Date date) throws CDLWikiException {
        List<MatchDTO> matches;

        if (date.before(new Date())) {
            matches = matchService.getMatchesByMajorBeforeDate(majorId, date);
        } else {
            matches = matchService.getMatchesByMajorAfterDate(majorId, date);
        }

        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping(value = "/major", params = {"majorId", "round"})
    public ResponseEntity<List<MatchDTO>> getMatchesByMajorAndRound(@RequestParam Integer majorId, @RequestParam RoundName round) throws CDLWikiException {
        List<MatchDTO> matches = matchService.getMatchesByMajorAndRound(majorId, round);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping("/round/{round}")
    public ResponseEntity<List<MatchDTO>> getMatchesByRound(@PathVariable RoundName round) throws CDLWikiException {
        List<MatchDTO> matches = matchService.getMatchesByRound(round);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> createMatch(@Valid @RequestBody MatchRequest matchRequest) throws CDLWikiException {
        String message = matchService.createMatch(matchRequest);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
