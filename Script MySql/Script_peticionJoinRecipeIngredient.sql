SELECT r.recipeName,r.recipeDescription,r.url,r.valoration,i.ingredientName,i.amount,i.price FROM recipe r JOIN ingredient i ON i.id = r.id WHERE r.recipeName = 'pulpo a la gallega'