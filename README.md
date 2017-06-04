# SpringerNatureNounExtractor
Extract occurrence of (NN) and (JJ &amp; NN) from the Amazon review file and prints its frequency distribution

Logic:

1. I have used Stanford CoreNLP for tagging ReviewText.
2. Then extracted the occurrence of JJ/JJR/JJS with NN/NNS i.e. adjective with common noun and only NN/NNS i.e. only common noun in tagged data.
3. Example: Great/JJ purchase/NN; outlets/NNS; chargers/NNS
4. Lemmatized the plural words to singular word using Stanford CoreNLP
5. Example: chargers ==> charger , products ==> products
6. For occurrence of Adjective with Noun, converted it into one word by adding using _ sign.
7. Example: good product ==> good_product
8. Count the number of occurrence of words and stored it in HashMap using keys as words and values as frequency of words.
9. Example: Key: "good_product" Value: 5


File Structure:

1. tagger/models Folder: contains the pre-trained models used to do POS tagging.
2. lib Folder: contains the jackson parser for parsing json file. Also contains Stanford PosTagger to perform POS tagging.
3. output Folder: contains the output generated which contains adjective and common noun combination. The project contain all the jars and model files required to run the project. It also contains generated output from the reviews.


Please pass one arguments while running the Main class:
1. args[0] = path of json file i.e. "Path_to_Json\Cell_Phones_and_Accessories_5_1000reviews.json"


Steps to run the project

1. Download, Extract and Import project in Eclipse.
2. Right Click on imported project Run As -> Run Configurations->Arguments Tab
3. Copy path of input review json file.
4. Click Run
