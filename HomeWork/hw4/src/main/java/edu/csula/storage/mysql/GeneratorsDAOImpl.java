package edu.csula.storage.mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.sql.*;

import edu.csula.storage.GeneratorsDAO;
import edu.csula.storage.Database;
import edu.csula.models.Generator;

public class GeneratorsDAOImpl implements GeneratorsDAO {
	private final Database context;

	// TODO: fill the Strings with the SQL queries as "prepated statements" and
	//       use these queries variable accordingly in the method below
	protected static final String getAllQuery = "SELECT * FROM Generators";
	protected static final String getByIdQuery = "SELECT * FROM Generators WHERE id = ?";
	protected static final String setQuery = "UPDATE Generators SET name = ?, description = ?, rate = ?, base_cost = ?, unlock_at = ? WHERE id = ?";
	protected static final String removeQuery = "DELETE FROM Generators WHERE id = ?";
	protected static final String addQuery = "INSERT INTO Generators (name, description, rate, base_cost, unlock_at, created_by) VALUES (?, ?, ?, ?, ?, ?)";

	public GeneratorsDAOImpl(Database context) {
		this.context = context;
	}

	@Override
	public List<Generator> getAll() {
		// TODO: get all generators from jdbc
		List<Generator> gens = new ArrayList<Generator>();

		try (Connection c = this.context.getConnection(); Statement s = c.createStatement()) {
			ResultSet r = s.executeQuery(this.getAllQuery);

			while (r.next()) {
				Generator g = new Generator(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4), r.getInt(5), r.getInt(6));
				gens.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gens;
	}

	@Override
	public Optional<Generator> getById(int id) {
		// TODO: get specific generator by id
		try(Connection c = context.getConnection(); PreparedStatement ps = c.prepareStatement(this.getByIdQuery)){
			Optional<Generator> hasGen = Optional.empty();
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			if(r.next()){
				Generator g = new Generator(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4), r.getInt(5), r.getInt(6));
				hasGen = Optional.of(g);
			}
			return hasGen;
		} catch (SQLException e){
			e.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public void set(int id, Generator generator) {
		// TODO: update specific generator by id
		try(Connection c = this.context.getConnection() ; PreparedStatement ps = c.prepareStatement(this.setQuery)){
			//name = ?, description = ?, rate = ?, base_cost = ?, unlock_at = ?
			ps.setString(1, generator.getName());
			ps.setString(2, generator.getDescription());
			ps.setInt(3, generator.getRate());
			ps.setInt(4, generator.getBaseCost());
			ps.setInt(5, generator.getUnlockAt());
			ps.setInt(6, id);
			ps.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public void add(Generator generator) {
		// TODO: implement jdbc logic to add a new generator
		try (Connection c = this.context.getConnection(); PreparedStatement ps = c.prepareStatement(this.addQuery)) {
			// (name, description, rate, base_cost, unlock_at, created_by)
			ps.setString(1, generator.getName());
			ps.setString(2, generator.getDescription());
			ps.setInt(3, generator.getRate());
			ps.setInt(4, generator.getBaseCost());
			ps.setInt(5, generator.getUnlockAt());
			ps.setInt(6, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		// TODO: implement jdbc logic to remove generator by id
		try (Connection c = this.context.getConnection(); PreparedStatement ps = c.prepareStatement(this.removeQuery)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
