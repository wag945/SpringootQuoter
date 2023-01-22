package org.springframework.quoters;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Track {

	@Id @GeneratedValue private Long id;
    private String lat;
    private String lon;
    private String identity;
    private String speed;
    private String course;

	protected Track() {
        lat = "0.0";
        lon = "0.0";
        identity = "Unknown";
        speed = "0";
        course = "0";
    }

    protected Track(String inlat, 
                    String inlon, 
                    String inidentity, 
                    String inspeed, 
                    String incourse) {
                        lat = inlat;
                        lon = inlon;
                        identity = inidentity;
                        speed = inspeed;
                        course = incourse;
                    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return this.lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSpeed() {
        return this.speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Quote))
			return false;
		Track track1 = (Track) o;
		return Objects.equals(id, track1.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Track{" + "id=" + id + ", lat=" + lat + ", lon=" + lon + '\'' + '}';
	}
}
