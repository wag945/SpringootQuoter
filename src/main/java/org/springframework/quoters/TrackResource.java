package org.springframework.quoters;

import java.util.Objects;

class TrackResource {

	private String type;
	private Track value;

	TrackResource(Track value, String type) {

		this.value = value;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Track getValue() {
		return value;
	}

	public void setValue(Track value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof TrackResource))
			return false;
		TrackResource that = (TrackResource) o;
		return Objects.equals(type, that.type) && Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, value);
	}

	@Override
	public String toString() {
		return "TrackResource{" + "type='" + type + '\'' + ", value=" + value + '}';
	}
}
