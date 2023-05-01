public interface PersonIterator { 
    /**
     * Gib true zurück , wenn der Iterator weitere Elemente enthält. 
     * Ansonsten false. 
     * @return true , wenn der Iteratorweitere Elemente enthält. 
     */ 
    public boolean hasNext(); 

    /**
     * Gibt das nächste Person −Objekt zurück 
     * @return das nächste Person −Objekt. 
     */ 
    public Person next();
}
