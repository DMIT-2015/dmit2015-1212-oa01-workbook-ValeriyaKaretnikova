package common.config;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;

@DataSourceDefinitions({

	@DataSourceDefinition(
		name="java:app/datasources/mssqlDS",
		className="com.microsoft.sqlserver.jdbc.SQLServerDataSource",
		url="jdbc:sqlserver://DMIT-Capstone1.ad.sast.ca;databaseName=DMIT2015_1212_A01_vkaretnikova1;TrustServerCertificate=true",   // change A01 to E01 if you are in section E01, change yourNaitUsername
		user="vkaretnikova1",
		password="RemotePassword200388962"),

})

@FacesConfig
@ApplicationScoped
public class ApplicationConfig {

}