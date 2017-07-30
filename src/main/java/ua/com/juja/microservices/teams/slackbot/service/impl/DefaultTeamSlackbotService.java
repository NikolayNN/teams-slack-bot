package ua.com.juja.microservices.teams.slackbot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.juja.microservices.teams.slackbot.dao.TeamRepository;
import ua.com.juja.microservices.teams.slackbot.model.Team;
import ua.com.juja.microservices.teams.slackbot.model.TeamRequest;
import ua.com.juja.microservices.teams.slackbot.service.TeamSlackbotService;
import ua.com.juja.microservices.teams.slackbot.util.Utils;

import javax.inject.Inject;

/**
 * @author Ivan Shapovalovv
 */
@Service
@Slf4j
public class DefaultTeamSlackbotService implements TeamSlackbotService {

    private final TeamRepository teamRepository;

    @Inject
    public DefaultTeamSlackbotService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team activateTeam(TeamRequest teamRequest) {
        Utils.checkNull(teamRequest,"Team request must not be null!");
        log.debug("Started Activate Team: '{}'", teamRequest.toString());
        Team activatedTeam = teamRepository.activateTeam(teamRequest);
        log.debug("Finished Activate Team: '{}'", activatedTeam.toString());
        log.info("Activate team finished correctly: '{}'", activatedTeam.getId());
        return activatedTeam;
    }
}
