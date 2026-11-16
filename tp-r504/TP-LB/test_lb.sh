#!/bin/bash

# Nombre d'appels
N=500
FICHIER=/tmp/reponses_lb.txt

echo "=== $N appels à http://localhost:83 ==="
echo

# Boucle : une nouvelle connexion à chaque appel (Connection: close)
for i in $(seq 1 $N); do
  curl -s -H "Connection: close" http://localhost:83
  echo
done > "$FICHIER"

# Aperçu des 10 premières réponses (pour voir l'alternance)
echo "--- 10 premières réponses ---"
head -10 "$FICHIER"
echo

# Comptage avec grep -c (Q2.6)
H1=$(grep -c "Hello 1" "$FICHIER")
H2=$(grep -c "Hello 2" "$FICHIER")
TOTAL=$(wc -l < "$FICHIER")

echo "--- Répartition (via grep) ---"
echo "Hello 1 : $H1"
echo "Hello 2 : $H2"
echo

echo "Total    : $TOTAL"
echo "Hello 1  : $H1 ($((H1 * 100 / TOTAL))%)"
echo "Hello 2  : $H2 ($((H2 * 100 / TOTAL))%)"
echo

# Vérification automatique du 50/50
if [ "$H1" -eq "$H2" ]; then
  echo " Répartition 50/50 : OK"
else
  echo " Répartition déséquilibrée (H1=$H1, H2=$H2)"
fi
