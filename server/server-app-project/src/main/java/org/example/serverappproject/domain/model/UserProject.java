package org.example.serverappproject.domain.model;

import java.time.LocalDate;

public class UserProject {
    private Long userId;
    private Long projectId;
    private LocalDate userAddAt;

    public UserProject(Long projectId, LocalDate userAddAt) {
        this.projectId = projectId;
        this.userAddAt = userAddAt;
    }

    public UserProject(Long userId, Long projectId, LocalDate userAddAt) {
        this.userId = userId;
        this.projectId = projectId;
        this.userAddAt = userAddAt;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getUserAddAt() {
        return userAddAt;
    }

    public void setUserAddAt(LocalDate userAddAt) {
        this.userAddAt = userAddAt;
    }
}
