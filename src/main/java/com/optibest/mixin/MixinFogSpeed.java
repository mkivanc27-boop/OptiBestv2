// Aynı Mixin içine veya yanına eklenebilir
// Oyuncunun hızını alıyoruz
double velocity = camera.getFocusedEntity().getVelocity().horizontalLength();
float speedFactor = (float) (velocity * 2.5); // Hızlandıkça sis 2-3 blok uzağa gider

float finalLimit = baseLimit + animationOffset + speedFactor;
RenderSystem.setShaderFogStart(finalLimit * 0.1F);
RenderSystem.setShaderFogEnd(finalLimit);

