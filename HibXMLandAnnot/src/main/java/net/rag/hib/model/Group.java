package net.rag.hib.model;

import java.util.HashSet;
import java.util.Set;

public class Group {

	int groupId;
	String groupName;
	
	Set<User> users = new HashSet();

    public void addUser(User user) {
        this.users.add(user);
    }
    
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}


	
	
}
