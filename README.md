# Reader-Excel
Reader Excel with API JAVA

# Introdução
As planilhas são comumente usadas para negócios e são populares entre os usuários. Não é incomum que os usuários solicitem acesso a alguns dados como uma planilha. Utlizei o Apache POI para ler planilha excel.

Est API consiste em um serviço externo usando o código java para ler o Excel e a biblioteca Java necessária (POI).

A Class Read Excel converte uma string de entrada codificada em base 64 em um ByteArrayInputStream e lê os dados do Excel. Usando as classes Apache POI , a classe itera a pasta de trabalho, convertendo a entrada do Excel em uma árvore JSONObject, que posteriormente é retornada como string JSON.
