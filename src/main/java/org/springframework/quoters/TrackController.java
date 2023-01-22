package org.springframework.quoters;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackController {

	private final static Track NONE = new Track();
	private final static Random RANDOMIZER = new Random();

	private final TrackRepository repository;

	public TrackController(TrackRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/api/tracks")
	public List<TrackResource> getAll() {

		return repository.findAll().stream()
			.map(track -> new TrackResource(track, "Track"))
			.collect(Collectors.toList());
	}

	@GetMapping("/api/tracks/{id}")
	public TrackResource getOne(@PathVariable Long id) {

		return repository.findById(id)
			.map(track -> new TrackResource(track, "Track"))
			.orElse(new TrackResource(NONE, "Track " + id + " does not exist"));
	}

	@GetMapping("/api/tracks/random")
	public TrackResource getRandomOne() {
		return getOne(nextLong(1, repository.count() + 1));
	}

	private long nextLong(long lowerRange, long upperRange) {
		return (long) (RANDOMIZER.nextDouble() * (upperRange - lowerRange)) + lowerRange;
	}
}
