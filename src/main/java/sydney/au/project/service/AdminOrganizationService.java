package sydney.au.project.service;

import java.util.List;

import sydney.au.project.model.Organization;



public interface AdminOrganizationService {

	public List<Organization> listOrganization(Integer page);


    public Integer countOrganization();


    public void saveOrganization(Organization organization);


    public void deleteOrganization(Integer oid);


    public Organization findOrganization(Integer oid);


    public void updateOrganization(Organization organization);


    public List<Organization> listOrganization();
}
