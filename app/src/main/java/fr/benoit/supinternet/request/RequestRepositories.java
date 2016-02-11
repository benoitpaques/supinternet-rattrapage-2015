package fr.benoit.supinternet.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import fr.benoit.supinternet.model.Repository;

/**
 * POJO used to match the request response sent by the Github api
 *
 * Created by benoit on 06/02/2016.
 */
public class RequestRepositories {

    @SerializedName("total_count")
    private long totalCount;

    @SerializedName("incomplete_results")
    private boolean incompleteResult;

    @SerializedName("items")
    private List<Repository> repositories;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompleteResult() {
        return incompleteResult;
    }

    public void setIncompleteResult(boolean incompleteResult) {
        this.incompleteResult = incompleteResult;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public String toString() {
        return "RequestRepositories{" +
                "totalCount=" + totalCount +
                ", incompleteResult=" + incompleteResult +
                ", repositories=" + repositories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestRepositories that = (RequestRepositories) o;

        if (totalCount != that.totalCount) return false;
        if (incompleteResult != that.incompleteResult) return false;
        return !(repositories != null ? !repositories.equals(that.repositories) : that.repositories != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (totalCount ^ (totalCount >>> 32));
        result = 31 * result + (incompleteResult ? 1 : 0);
        result = 31 * result + (repositories != null ? repositories.hashCode() : 0);
        return result;
    }
}
