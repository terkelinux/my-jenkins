pipelineJob('my-pipeline') { // ok
  def repo = 'https://github.com/terkelinux/my-jenkins.git'

  triggers {
    scm('H/5 * * * *')
  }
  description("My Pipeline")

  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('main') // this is fine
          scriptPath('jobs/my-pipeline.groovy')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }
      }
    }
  }
}

pipelineJob('flask-pipeline') { // ok
  def repo = 'https://github.com/yanivomc/devopshift-welcome.git'

  triggers {
    scm('H/5 * * * *')
  }
  description("Flask Pipeline")

  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('elbit/jenkinsdec26') // this is fine
          scriptPath('students/Terkel/080124/jobs/flask-pipeline.groovy')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }
      }
    }
  }
}
