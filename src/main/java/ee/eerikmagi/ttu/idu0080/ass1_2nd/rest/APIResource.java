package ee.eerikmagi.ttu.idu0080.ass1_2nd.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ee.eerikmagi.ttu.idu0080.ass1_2nd.dao.GamesDAO;
import ee.eerikmagi.ttu.idu0080.ass1_2nd.model.ui.UIGame;
import ee.eerikmagi.ttu.idu0080.ass1_2nd.rest.json.GamesResponse;

/**
 * Resource that handles API requests
 */
@Path("games")
public class APIResource {
	@Inject
	private GamesDAO GAMES;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGames() {
		List<UIGame> games = UIGame.fromGameList(GAMES.list());
		
		return Response.ok(
			new GamesResponse()
				.setGames(games)
				.setSuccess(true)
		).build();
	}
}
