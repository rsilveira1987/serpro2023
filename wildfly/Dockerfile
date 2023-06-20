FROM jboss/wildfly

USER root
RUN passwd --delete root

USER jboss

ENV WILDFLY_HOME=/opt/jboss/wildfly
ENV JBOSS_CLI=/opt/jboss/wildfly/bin/jboss-cli.sh

# Expose the ports we're interested in
EXPOSE 8080
EXPOSE 9990

# copy JDBC postgres driver
COPY postgresql-42.6.0.jar /tmp

# copy custom daemon scripts
COPY jdbc-daemon.sh /tmp

# copy custom standalone + hook
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]