#!/bin/bash
# Daemon JDBC waits wildfly and then deploys JDBC drivers 

# check wildfly status
STATUS=`$JBOSS_CLI -c command=':read-attribute(name=server-state)' | grep running -c`
if [ "$STATUS" -eq "1" ]; then
    
    # check postgre jdbc driver
    IS_POSTGRE_DRIVER_DEPLOYED=$(/opt/jboss/wildfly/bin/jboss-cli.sh "connect","/subsystem=datasources:installed-drivers-list" | grep driver-name | grep postgresql-42.6.0.jar -c)
    if [ "$IS_POSTGRE_DRIVER_DEPLOYED" -eq "0" ]; then
        # Deploy pgsql JDBC driver
        /opt/jboss/wildfly/bin/jboss-cli.sh "connect","deploy --force /tmp/postgresql-42.6.0.jar","data-source add --name=PostgreDS --driver-name=postgresql-42.6.0.jar  --driver-class=org.postgresql.Driver --jndi-name=java:/PostgresDS --connection-url=jdbc:postgresql://127.0.0.1:5432/mydatabase  --user-name=postgres --password=postgres"
    fi
    
fi
 






