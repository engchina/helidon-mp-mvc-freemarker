<html>
    <head>
      <title>Helidon Sites</title>
    </head>
    <body>
      <h1>Helidon Sites</h1>
      <p>Sites:</p>
      <ul>
		<#list helidonSites as helidonSite>
			<li><a href="${helidonSite.site}" target="_blank">${helidonSite.name}</a></li>
		</#list>
	  </ul>
	  <a href="/web/index">Hello World</a>
    </body>
</html>