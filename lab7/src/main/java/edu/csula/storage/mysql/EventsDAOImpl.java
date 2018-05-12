package edu.csula.storage.mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.sql.*;

import edu.csula.storage.EventsDAO;
import edu.csula.storage.Database;
import edu.csula.models.Event;

public class EventsDAOImpl implements EventsDAO {
	private final Database context;

	// TODO: fill the Strings with the SQL queries as "prepated statements" and
	//       use these queries variable accordingly in the method below
	protected static final String getAllQuery = "SELECT * FROM Events";
	protected static final String getByIdQuery = "SELECT * FROM Events WHERE id = ?";
	protected static final String setQuery = "UPDATE Events SET name = ?, description = ?, trigger_at = ? WHERE id = ?";
	protected static final String removeQuery = "DELETE FROM Events WHERE id = ?";
	protected static final String addQuery = "INSERT INTO Events (name, description, trigger_at, created_by) VALUES (?, ?, ?, ?)";

	public EventsDAOImpl(Database context) {
		this.context = context;
	}

	@Override
	public List<Event> getAll() {
		// TODO: get all events from jdbc
		List<Event> events = new ArrayList<Event>();

		try (Connection c = this.context.getConnection(); Statement s = c.createStatement()) {
			ResultSet r = s.executeQuery(this.getAllQuery);

			while (r.next()) {
				Event e = new Event(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4));
				events.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return events;
	}

	@Override
	public Optional<Event> getById(int id) {
		// TODO: get specific event by id
		try (Connection c = context.getConnection(); PreparedStatement ps = c.prepareStatement(this.getByIdQuery)) {
			Optional<Event> hasEvent = Optional.empty();
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			if(r.next()){
				Event event = new Event(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4));
				hasEvent = Optional.of(event);
			}
			return hasEvent;

		} catch (SQLException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public void set(int id, Event event) {
		// TODO: update specific event by id
		//s.executeUpdate()
		//prepareStatement
		try (Connection c = this.context.getConnection(); PreparedStatement ps = c.prepareStatement(this.setQuery)) {
			ps.setString(1, event.getName());
			ps.setString(2, event.getDescription());
			ps.setInt(3, event.getTriggerAt());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Event event) {
		// TODO: implement jdbc logic to add a new event
		//s.executeUpdate()
		try (Connection c = this.context.getConnection(); PreparedStatement ps = c.prepareStatement(this.addQuery)) {
			ps.setString(1, event.getName());
			ps.setString(2, event.getDescription());
			ps.setInt(3, event.getTriggerAt());
			ps.setInt(4, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void remove(int id) {
		// TODO: implement jdbc logic to remove event by id
		//s.executeUpdate()
		try (Connection c = this.context.getConnection(); PreparedStatement ps = c.prepareStatement(this.removeQuery)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
